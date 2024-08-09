package com.example.yourshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val data = ArrayList<String>()
    private val data1 = ArrayList<String>()
    private val data2 = ArrayList<String>()
    private val data3 = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pname = findViewById(R.id.ed1) as EditText
        val price = findViewById(R.id.ed2) as EditText
        val qty = findViewById(R.id.ed3) as EditText

        val subtotal = findViewById(R.id.ed4) as EditText
        val pay = findViewById(R.id.ed5) as EditText
        val bal = findViewById(R.id.ed6) as EditText


        val b1 = findViewById(R.id.btn1) as Button
        val b2 = findViewById(R.id.btn2) as Button

        b2.setOnClickListener{
            val sub = Integer.parseInt(subtotal.getText().toString())
            val payment = Integer.parseInt(pay.getText().toString())
            val balance = payment - sub
            bal.setText(balance.toString())
        }




        b1.setOnClickListener{

            val prodname = pname.text.toString()
            val pricee = price.text.toString().toInt()
            val qtyy = qty.text.toString().toInt()

            val total = pricee * qtyy

            data.add(prodname)
            data1.add(pricee.toString())
            data2.add(qtyy.toString())
            data3.add(total.toString())

            val table = findViewById(R.id.tb1) as TableLayout

            val row = TableRow(this)
            val t1 = TextView(this)
            val t2 = TextView(this)
            val t3 = TextView(this)
            val t4 = TextView(this)

            var tot: String
            var sum = 0

            for(i in data.indices){
                val pa = data[i]
                val prc = data1[i]
                val qt = data2[i]
                val to = data3[i]

                t1.text = pa
                t2.text = prc
                t3.text = qt
                t4.text = to

                sum = sum + Integer.parseInt(data3[i])
            }

            row.addView(t1)
            row.addView(t2)
            row.addView(t3)
            row.addView(t4)

            table.addView(row)

            subtotal.setText(sum.toString())

            pname.setText("")
            price.setText("")
            qty.setText("")

            pname.requestFocus()


        }

    }
}