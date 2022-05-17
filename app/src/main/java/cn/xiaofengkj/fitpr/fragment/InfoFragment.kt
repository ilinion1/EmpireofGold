package cn.xiaofengkj.fitpr.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.xiaofengkj.fitpr.R
import cn.xiaofengkj.fitpr.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {
    lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tv1.setText(R.string.info1)
        binding.tv2.setText(R.string.info2)
        binding.tv3.setText(R.string.info3)
        binding.tv4.setText(R.string.info4)
    }
}