package com.raion.furnitale.ui.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.raion.furnitale.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var categoryBinding: ActivityCategoryBinding
    private val args: CategoryActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryBinding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(categoryBinding.root)
        val index = args.index

        categoryBinding.viewPager.adapter = CategoryPageAdapter(supportFragmentManager)
        categoryBinding.bubbleTab.setupWithViewPager(categoryBinding.viewPager)
        categoryBinding.viewPager.currentItem = index


    }
}