package com.fakhril.biorv

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val context: Context)
    :FragmentStateAdapter(fragmentActivity)
{
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 ->  BoardFragment.newInstance(
                context.resources.getString(R.string.title_onboarding),
                context.resources.getString(R.string.description_onboarding),
                R.drawable.fakhril
            )
            1 -> BoardFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                context.resources.getString(R.string.description_onboarding_2),
                R.drawable.f5
            )
            else -> BoardFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                context.resources.getString(R.string.description_onboarding_3),
                R.drawable.f9)
        }
    }

}