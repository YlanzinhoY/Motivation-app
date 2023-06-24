package devapp.lanze.motivation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import devapp.lanze.motivation.R
import devapp.lanze.motivation.classes.DataSharedPreferences
import devapp.lanze.motivation.classes.MotivationDataKeys
import devapp.lanze.motivation.data.PharaseMock
import devapp.lanze.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var categoryId = MotivationDataKeys.FILTER.ALL
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonNewPhrase.setOnClickListener(this)
        imagesSetClickListner()
        handleUsername()
        generatePhrase()
    }


    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase) {
            generatePhrase()
        }
        else if(view.id in listOf(R.id.image_all_inclusive, R.id.image_smile, R.id.image_sun)) {
            handleFilter(view.id)
        }
    }

    private fun handleFilter(id: Int) {

        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when(id) {
            R.id.image_all_inclusive -> {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 1
            }
            R.id.image_smile -> {
                binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 2
            }
            R.id.image_sun -> {
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 3
            }

        }
    }

    private fun handleUsername(){
        val getPref = DataSharedPreferences(this).getString(MotivationDataKeys.USER_NAME)
        binding.textTitle.text = "Olá, $getPref!"
    }


    private fun imagesSetClickListner() {
        binding.imageAllInclusive.setOnClickListener(this)
        binding.imageSmile.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
    }

    private fun generatePhrase() {
        binding.textFrase.text = PharaseMock().getPhrase(categoryId)
    }


}