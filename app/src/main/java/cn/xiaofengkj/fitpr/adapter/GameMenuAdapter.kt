package cn.xiaofengkj.fitpr.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cn.xiaofengkj.fitpr.fragment.GameFragment
import cn.xiaofengkj.fitpr.fragment.InfoFragment
import cn.xiaofengkj.fitpr.fragment.ExperienceFragment
import cn.xiaofengkj.fitpr.fragment.SettingsFragment

class GameMenuAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> GameFragment()
            1 -> ExperienceFragment()
            2 -> SettingsFragment()
            else -> InfoFragment()
        }
    }
}