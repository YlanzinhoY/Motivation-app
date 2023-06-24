package devapp.lanze.motivation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import devapp.lanze.motivation.R
import devapp.lanze.motivation.classes.DataSharedPreferences
import devapp.lanze.motivation.classes.MotivationDataKeys
import devapp.lanze.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonSave.setOnClickListener(this)
        hasName()
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_save) {
            handleSave()
        }
    }


    private fun hasName() {
        val getPref = DataSharedPreferences(this).getString(MotivationDataKeys.USER_NAME)
        if(getPref.isNotBlank()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent).apply {
                finish()
            }
        }
    }

    private fun handleSave() {
        val name = binding.editInputName.text.toString()
        if(name.isNotBlank()) {
            DataSharedPreferences(this).storeKey(MotivationDataKeys.USER_NAME, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent).apply {
                finish()
            }
        } else {
            Toast.makeText(this, R.string.error_inform_your_name, Toast.LENGTH_SHORT).show()
        }
    }
}