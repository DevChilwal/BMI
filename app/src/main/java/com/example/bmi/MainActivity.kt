package com.example.bmi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuCompat
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var isClear: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener(this)
        if (isClear) {
            isClear = false
            binding.btnCalculate.setText("CALCULATE")

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        MenuCompat.setGroupDividerEnabled(menu!!, true);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        val builder= AlertDialog.Builder(this)
        builder.setMessage("Do you want to exit ?")
        builder.setTitle("Alert !")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes")
        {
                dialog, which-> finish()
        }
        builder.setNegativeButton("No")
        { dialog, which -> dialog.cancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_dev -> {

                val intent = Intent(this, aboutdev::class.java)
                startActivity(intent)
                return true
            }
            R.id.bmi_chart -> {
                val intent = Intent(this, bmi_chart::class.java)
                startActivity(intent)
                return true
            }
            R.id.exit_app -> {
                finish()
                System.exit(0)
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.about_bmi -> {
                val intent = Intent(this,what_is_bmi::class.java
//                    Intent.ACTION_VIEW,
//                    Uri.parse("www.google.com")
                )
                startActivity(intent)

            }
            R.id.dial -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:9917576899")
                startActivity(intent)
            }
            R.id.email -> {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:") // only email apps should handle this
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("chilwald3@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "  Hey  ")
                }
                startActivity(intent)
            }
            R.id.ratingbar ->{
                val intent = Intent(this,ratingbar::class.java)
                startActivity(intent)
            }
        }
            return super.onOptionsItemSelected(item)
        }
        override fun onClick(view: View) {
            when (view?.id) {
                R.id.btn_calculate -> {
                    if (binding.height.text!!.isEmpty() && binding.weight.text!!.isEmpty()) {
                        binding.height.requestFocus()
                        Toast.makeText(this, "Enter the height & Weight", Toast.LENGTH_SHORT).show()
                    } else if (binding.weight.text!!.isEmpty()) {
                        binding.weight.requestFocus()
                        Toast.makeText(this, "Enter the weight", Toast.LENGTH_SHORT).show()
                    } else if (binding.height.text!!.isEmpty()) {
                        binding.height.requestFocus()
                        Toast.makeText(this@MainActivity, "please enter height  ", Toast.LENGTH_LONG).show()
                    }
                    if (isClear) {
                        binding.height.isEnabled = true
                        binding.weight.isEnabled = true
                        isClear = false
                        binding.btnCalculate.text = "Calculate"
                        binding.BMIResult.setText("")
                        binding.weight.text!!.clear()
                        binding.height.text!!.clear()
                        Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
                    } else {
                        if (binding.height.text.toString()
                                .isNotEmpty() && binding.weight.text.toString().isNotEmpty()) {
                            if (!isClear) {

                                isClear = true

                                binding.btnCalculate.setText("Clear")

                                val height = (binding.height.text.toString()).toDouble()
                                val weight = (binding.weight.text.toString()).toDouble()
                                binding.height.isEnabled = false
                                binding.weight.isEnabled = false

                                if (height == 0.0 || weight == 0.0) {
                                    Toast.makeText(this, "Invalid height or weight ", Toast.LENGTH_SHORT).show()

                                } else {
                                    val Height_in_metre = height.toFloat() / 100
                                    val total = weight.toFloat() / (Height_in_metre * Height_in_metre)
                                    val BMI = (total * 100).roundToInt() / 100.0


                                    if (BMI < 18.5) {
                                        binding.BMIResult.text = " Your BMI is :- $BMI \n You are Under Weight"
                                    } else if (BMI >= 18.5 && BMI < 24.9) {
                                        binding.BMIResult.text = " Your BMI is :- $BMI \n You are Healthy"
                                    } else if (BMI >= 24.9 && BMI < 30) {
                                        binding.BMIResult.text = " Your BMI is :- $BMI \n Your are Over Weight"
                                    } else {
                                        binding.BMIResult.text =
                                            " Your BMI is :- $BMI \n You Are Suffering from Obesity"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    override fun onResume() {
        super.onResume()
    }
    }