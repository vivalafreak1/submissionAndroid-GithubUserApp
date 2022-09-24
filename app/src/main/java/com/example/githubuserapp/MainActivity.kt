package com.example.githubuserapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataName = resources.getStringArray(R.array.data_name)
            val dataLocation = resources.getStringArray(R.array.data_location)
            val dataRepository = resources.getStringArray(R.array.data_repository)
            val dataCompany = resources.getStringArray(R.array.data_company)
            val dataFollower = resources.getIntArray(R.array.data_follower)
            val dataFollowing = resources.getIntArray(R.array.data_following)
            val dataAvatar = resources.obtainTypedArray(R.array.data_avatar)
            val listUser = ArrayList<User>()
            for (i in dataUsername.indices) {
                val user = User(
                    dataUsername[i],
                    dataName[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataCompany[i],
                    dataFollower[i],
                    dataFollowing[i],
                    dataAvatar.getResourceId(i, -1)
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showSelectedUser(user : User) {
        Toast.makeText(this, "Kamu memilih " + user.username, Toast.LENGTH_SHORT).show()
    }


    private fun showRecyclerList() {
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallBack(object: ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }
}