package com.example.bmi

import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.MenuCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bmi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isClear: Boolean = false
    lateinit var viewModel: ViewModelBmi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnCalculate.setOnClickListener {

            if (isClear) {
                binding.height.isEnabled = true
                binding.weight.isEnabled = true
                isClear = false
                binding.btnCalculate.text = "Calculate"
                binding.BMIResult.setText("")
                binding.status.setText("")
                binding.weight.text!!.clear()
                binding.height.text!!.clear()
                Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.height.text.toString().isNotEmpty() && binding.weight.text.toString().isNotEmpty()) {
                    if (!isClear) {
                        // initialize the variable
                        isClear = true
                        binding.btnCalculate.text = "Clear"
                        binding.height.isEnabled = false
                        binding.weight.isEnabled = false
                    }

                }
                viewModel.validate()


            }


        }

        onBackPressedDispatcher.addCallback(this, callback)


        viewModel = ViewModelProvider(this)[ViewModelBmi::class.java]
        binding.lifecycleOwner = this

        binding.myviewmodel = viewModel



        viewModel.errormessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.BMI.observe(this, Observer {
            binding.BMIResult.text = it.toString()
        })
        viewModel.statusofhealth.observe(this, Observer {
            binding.statusofhealth.text = it.toString()
        })

        callback.isEnabled = true
        if (isClear) {
            isClear = false
            binding.btnCalculate.text = "CALCULATE"

        }
    }

    private var callback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle(resources.getString(R.string.app_name))
            alertDialog.setMessage("Are you sure to exit ?")
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton(
                "Yes"
            ) { di, p1 -> finish() }
            alertDialog.setNegativeButton(
                "No"
            ) { p0, p1 -> }
            alertDialog.show()

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        MenuCompat.setGroupDividerEnabled(menu!!, true)//add horizontal divider
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_dev -> {

                val intent = Intent(this, aboutdev::class.java)
                startActivity(intent)
//                Toast.makeText(this,"About BMI", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.bmi_chart -> {
                val intent = Intent(this, bmi_chart::class.java)
                //Toast.makeText(this," BMI Chart", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                return true
            }

            R.id.about_bmi -> {
                val intent = Intent(this,)
                startActivity(intent)
                return true

            }
            R.id.dial -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:4656113616")
                startActivity(intent)
            }
            R.id.email -> {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:") // only email apps should handle this
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("xyz@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, " Hey ")

                }
                startActivity(intent)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "not app found", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.ratingbar -> {
                binding.rateus.visibility = View.VISIBLE
                binding.rateus.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                    Toast.makeText(this, " Rated $rating", Toast.LENGTH_SHORT).show()
                    binding.ratingbar.visibility = View.GONE
                }
            }

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001) {
            if (grantResults.isNotEmpty() && permissions[0].equals(PERMISSION_GRANTED)) {

            } else {
                Toast.makeText(this, "Please give permission", Toast.LENGTH_SHORT).show()
            }

        }
    }


    //Calling method end
}