package com.raion.furnitale.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.raion.furnitale.R
import com.raion.furnitale.databinding.AccountFragmentBinding
import com.raion.furnitale.ui.SignInActivity
import com.raion.furnitale.ui.home.HomeFragment
import kotlinx.android.synthetic.main.account_fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class AccountFragment : Fragment() {

    private var _accountBinding: AccountFragmentBinding? = null
    private val accountBinding get() = _accountBinding

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _accountBinding = AccountFragmentBinding.inflate(layoutInflater, container, false)
        return accountBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = activity?.let { GoogleSignIn.getClient(it, gso) }!!

        val account = GoogleSignIn.getLastSignedInAccount(activity)

        if (account != null) {
            val personName = account.displayName
            accountBinding?.tvNamaProfile?.text = personName
            val personEmail = account.email
            accountBinding?.tvMemberSince?.text = personEmail
        }

        accountBinding?.btnLogout?.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        auth.signOut()
        mGoogleSignInClient.signOut().addOnCompleteListener {
            val intent = Intent(activity, SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        _accountBinding = null
        super.onDestroyView()
    }


}