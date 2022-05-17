package cn.xiaofengkj.fitpr.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.xiaofengkj.fitpr.adapter.ExperienceAdapter
import cn.xiaofengkj.fitpr.databinding.FragmentExperienceBinding


class ExperienceFragment : Fragment() {
    lateinit var binding: FragmentExperienceBinding
    lateinit var experienceAdapter: ExperienceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExperienceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        experienceAdapter = ExperienceAdapter()
        binding.rcExperience.adapter = experienceAdapter
        experienceAdapter.listGame.addAll(listExperience)
    }

    override fun onResume() {
        super.onResume()
        experienceAdapter.listGame.clear()
        experienceAdapter.listGame.addAll(listExperience)
        experienceAdapter.notifyDataSetChanged()
    }

    companion object{
        var listExperience = arrayListOf<String>()
    }
}