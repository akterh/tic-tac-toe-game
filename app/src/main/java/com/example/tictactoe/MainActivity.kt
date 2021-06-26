package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun clickedBtn(view:View){

        val selectedBtn = view as Button
        var cellId = 0
        when(selectedBtn.id){
            R.id.btn1-> cellId = 1
            R.id.btn2-> cellId = 2
            R.id.btn3-> cellId = 3
            R.id.btn4-> cellId = 4
            R.id.btn5-> cellId = 5
            R.id.btn6-> cellId = 6
            R.id.btn7-> cellId = 7
            R.id.btn8-> cellId = 8
            R.id.btn9-> cellId = 9
        }
        // Log.d("btnValue",selectedBtn.shadowColor.toString())
        //Log.d("btnValue cellId",cellId.toString())

        playGame(cellId,selectedBtn)


    }


    var activePlayer = 1
    val player1= ArrayList<Int>()
    val player2 = ArrayList<Int>()

    fun playGame(cellId:Int,selecteBtn:Button){

        if (activePlayer==1){
            selecteBtn.text = "x"
            selecteBtn.setBackgroundColor(getColor(R.color.purple_700))
            if (player1.size<3){
                player1.add(cellId)
            }else{

                Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show()
            }

            activePlayer =2
        }else{
            selecteBtn.text = "0"
            selecteBtn.setBackgroundColor(getColor(R.color.teal_200))

            if (player2.size<3){
                player2.add(cellId)
            }else{
                selecteBtn.isEnabled = false
                Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show()
            }
            activePlayer =1
        }
        selecteBtn.isEnabled = false
        checkWinner()

    }
    var winner = -1
    fun checkWinner(){
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }else if (player2.contains(1)&& player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }else if (player2.contains(4)&& player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }else if (player2.contains(7)&& player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }else if (player2.contains(1)&& player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }else if (player2.contains(2)&& player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }else if (player2.contains(3)&& player2.contains(6) && player2.contains(9)){
            winner = 2
        }
        if (winner==1){
            Toast.makeText(this,"Player 1 win the Game",Toast.LENGTH_LONG).show()

        }else if (winner==2){
            Toast.makeText(this,"Player 2 wins the Game",Toast.LENGTH_LONG).show()
        }
    }



}