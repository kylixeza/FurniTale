package com.raion.furnitale.ui.categories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.raion.furnitale.ui.categories.accessories.AccessoriesFragment
import com.raion.furnitale.ui.categories.bathroom.BathroomFragment
import com.raion.furnitale.ui.categories.bedroom.BedroomFragment
import com.raion.furnitale.ui.categories.kitchen.KitchenFragment
import com.raion.furnitale.ui.categories.livingroom.LivingRoomFragment
import com.raion.furnitale.ui.categories.outdoor.OutdoorFragment

class CategoryPageAdapter(fm: FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 6
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = LivingRoomFragment()
            1 -> fragment = BedroomFragment()
            2 -> fragment = KitchenFragment()
            3 -> fragment = BathroomFragment()
            4 -> fragment = OutdoorFragment()
            5 -> fragment = AccessoriesFragment()
        }
        return fragment as Fragment
    }


}