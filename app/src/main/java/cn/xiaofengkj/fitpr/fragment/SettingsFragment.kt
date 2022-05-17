package cn.xiaofengkj.fitpr.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import cn.xiaofengkj.fitpr.R
import cn.xiaofengkj.fitpr.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (countJug == 2){
            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.main_color))
            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        } else {
            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.main_color))
            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        }
        clickListener()
    }

    private fun clickListener(){
        binding.cardView1.setOnClickListener {
            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.main_color))
            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            countJug = 2
        }
        binding.cardView2.setOnClickListener {
            binding.cardView2.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.main_color))
            binding.cardView1.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            countJug = 3
        }
    }

    override fun onPause() {
        super.onPause()
    }

    companion object{
        var countJug = 2
    }

}