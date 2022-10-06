package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        try {
            val imgAvatar: ImageView = findViewById(R.id.img_item_avatar)
            val tvName: TextView = findViewById(R.id.tv_item_name)
            val tvUsername: TextView = findViewById(R.id.tv_item_username)
            val tvCompany: TextView = findViewById(R.id.tv_item_company)
            val tvFollower: TextView = findViewById(R.id.tv_item_follower)
            val tvFollowing: TextView = findViewById(R.id.tv_item_following)
            val tvLocation: TextView = findViewById(R.id.tv_item_location)
            val tvRepository: TextView = findViewById(R.id.tv_item_repository)
            val person = intent.getParcelableExtra<User>(EXTRA_USER) as User
            if (person != null) {
                //set value pada layout
                val nameText = person.name
                val imgFoto = person.avatar
                val usernameText = person.username
                val companyText = person.company
                val followerText = person.follower
                val followingText = person.following
                val locationText = person.location
                val repositoryText = person.repository

                imgAvatar.setImageResource(imgFoto)
                tvName.text = nameText
                tvUsername.text = usernameText
                tvCompany.text = companyText
                tvFollower.text = followerText
                tvFollowing.text = followingText
                tvLocation.text = locationText
                tvRepository.text = repositoryText
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}