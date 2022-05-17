package cn.xiaofengkj.fitpr.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import cn.xiaofengkj.fitpr.R
import cn.xiaofengkj.fitpr.adapter.GameMenuAdapter
import cn.xiaofengkj.fitpr.databinding.ActivityMenuBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    lateinit var viewPagerAdapter: GameMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewPagerAdapter()
        setTabLayout()
    }

    private fun setViewPagerAdapter() {
        viewPagerAdapter = GameMenuAdapter(this)
        binding.viewPagId.adapter = viewPagerAdapter
    }

    private fun setTabLayout(){
        binding.tabLayoutId.tabIconTint = null
        TabLayoutMediator(binding.tabLayoutId, binding.viewPagId){ tab, pos ->
            when(pos){
                0->{
                    tab.setIcon(R.drawable.ic_game)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.tab_menu))
                }
                1->{
                    tab.setIcon(R.drawable.ic_result)
                    tab.icon?.setTint(ContextCompat.getColor(this@MenuActivity,
                        R.color.tab_menu_dark
                    ))
                }
                2->{
                    tab.setIcon(R.drawable.ic_settings)
                    tab.icon?.setTint(ContextCompat.getColor(this@MenuActivity,
                        R.color.tab_menu_dark
                    ))
                }
                else->{
                    tab.setIcon(R.drawable.ic_info)
                    tab.icon?.setTint(ContextCompat.getColor(this@MenuActivity,
                        R.color.tab_menu_dark
                    ))
                }
            }
        }.attach()

        binding.tabLayoutId.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(this@MenuActivity, R.color.tab_menu))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(this@MenuActivity, R.color.tab_menu_dark))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}