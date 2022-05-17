package cn.xiaofengkj.fitpr.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import cn.xiaofengkj.fitpr.R
import cn.xiaofengkj.fitpr.adapter.GameAdapter
import cn.xiaofengkj.fitpr.databinding.FragmentGameBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GameFragment : Fragment(), GameAdapter.ClickItem {
    lateinit var binding: FragmentGameBinding
    private val startGame = listOf(R.drawable.start_game,R.drawable.start_game,R.drawable.start_game,
        R.drawable.start_game,R.drawable.start_game,R.drawable.start_game,R.drawable.start_game,
        R.drawable.start_game,R.drawable.start_game,R.drawable.start_game,)
    private val twoJug = listOf(R.drawable.jug, R.drawable.lit1,R.drawable.lit2, R.drawable.lit3,
        R.drawable.lit4, R.drawable.fruts, R.drawable.king1, R.drawable.king2, R.drawable.jug,
        R.drawable.sunduk)
    private val threeJug = listOf(R.drawable.jug, R.drawable.lit1,R.drawable.lit2, R.drawable.lit3,
        R.drawable.jug, R.drawable.fruts, R.drawable.king1, R.drawable.king2, R.drawable.jug,
        R.drawable.sunduk)
    private var countGame = 0

    lateinit var gameAdapter: GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameAdapter = GameAdapter(this)
        gameAdapter.listGame.addAll(startGame)
        binding.rcGame.adapter = gameAdapter
        binding.rcGame.layoutManager = GridLayoutManager(context, 2)
        binding.tvGameExperience.text = countGame.toString()
    }


    override fun onClickItem(position: Int) {
        setTwoJug(position)
        setThreeJug(position)
    }

    private fun setTwoJug(position: Int){
        if (SettingsFragment.countJug == 2){
            lifecycleScope.launch {
                val imageRandom = twoJug[(0..9).random()]
                gameAdapter.listGame[position] = imageRandom
                gameAdapter.notifyItemChanged(position)
                checkImage(imageRandom)
                binding.cardResult.visibility = View.VISIBLE
                delay(1500)
                binding.cardResult.visibility = View.GONE
                gameAdapter.listGame[position] = R.drawable.start_game
                gameAdapter.notifyItemChanged(position)
            }
        }
    }

    private fun setThreeJug(position: Int){
        if (SettingsFragment.countJug == 3){
            lifecycleScope.launch {
                val imageRandom = threeJug[(0..9).random()]
                gameAdapter.listGame[position] = imageRandom
                gameAdapter.notifyItemChanged(position)
                binding.cardResult.visibility = View.VISIBLE
                delay(1500)
                binding.cardResult.visibility = View.GONE
                gameAdapter.listGame[position] = R.drawable.start_game
                gameAdapter.notifyItemChanged(position)
                checkImage(imageRandom)
            }
        }
    }

    private fun checkImage(image: Int){
        if (image == R.drawable.lit1 || image == R.drawable.lit2 || image == R.drawable.lit3 ||
            image == R.drawable.lit4) {
            countGame += 50
            binding.tvGameExperience.text = countGame.toString()
            ExperienceFragment.listExperience.add("50")
            setResult("50")
        }
        if (image == R.drawable.king1 || image == R.drawable.king2) {
            countGame += 100
            binding.tvGameExperience.text = countGame.toString()
            ExperienceFragment.listExperience.add("100")
            setResult("100")
        }
        if (image == R.drawable.jug) {
            countGame -= 100
            binding.tvGameExperience.text = countGame.toString()
            ExperienceFragment.listExperience.add("-100")
            setResult("-100")
        }
        if (image == R.drawable.sunduk) {
            countGame += 200
            binding.tvGameExperience.text = countGame.toString()
            ExperienceFragment.listExperience.add("200")
            setResult("200")
        }
        if (image == R.drawable.fruts) {
            countGame += 80
            binding.tvGameExperience.text = countGame.toString()
            ExperienceFragment.listExperience.add("80")
            setResult("80")
        }
    }

    private fun setResult(result: String){
        binding.tvGameResult.text = result
    }
}