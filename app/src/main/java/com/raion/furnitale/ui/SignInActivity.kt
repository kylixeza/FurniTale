package com.raion.furnitale.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.raion.furnitale.R
import com.raion.furnitale.databinding.ActivitySignInBinding
import com.shashank.sony.fancytoastlib.FancyToast
import java.lang.Exception

class SignInActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 2
    private var mGoogleSignInClient: GoogleSignInClient? = null
    private lateinit var gso: GoogleSignInOptions
    private lateinit var mAuth: FirebaseAuth

    private var _signInBinding: ActivitySignInBinding? = null
    private val signInBinding get() = _signInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding?.root)

        mAuth = FirebaseAuth.getInstance()

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.google_api_key))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        signInBinding?.loginGoogle?.setOnClickListener {
            signIn()
        }

        signInBinding?.apply {
            tvRegisterClick.setOnClickListener {
                FancyToast.makeText(this@SignInActivity,"This feature is unavailable right now", FancyToast.LENGTH_SHORT, FancyToast.INFO, false).show()
            }
            btnLogin.setOnClickListener {
                FancyToast.makeText(this@SignInActivity, "You just can login with google account",  FancyToast.LENGTH_SHORT, FancyToast.INFO, false).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        updateUI(currentUser)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val sweetSuccess  = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(getString(R.string.login_success))
                sweetSuccess.show()
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                authWithGoogle(account!!)
            } catch (e: Exception) {
                e.printStackTrace()
                val sweetError = SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(getString(R.string.login_failed))
                sweetError.show()
                Log.e("Google Account Fail", e.toString())
            }
        }
    }

    private fun authWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user = mAuth.currentUser
                    updateUI(user)
                } else {
                    Log.d(SignInActivity::class.java.simpleName, "SignIn Failed")
                }
            }
    }

    private fun signIn() {
        val intent = mGoogleSignInClient?.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)
    }

    private fun updateUI(account: FirebaseUser?) {
        if (account != null) {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _signInBinding = null
    }
}