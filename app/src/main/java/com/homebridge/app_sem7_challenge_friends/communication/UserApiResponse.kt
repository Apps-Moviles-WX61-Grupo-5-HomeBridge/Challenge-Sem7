package com.homebridge.app_sem7_challenge_friends.communication

import com.homebridge.app_sem7_challenge_friends.models.Person

class UserApiResponse(private val name: UserNameApiResponse, private val email: String, private val cell: String, private val picture: UserPictureApiResponse) {
    fun toPerson(): Person{
        return Person(
            firstName = name.first,
            lastName = name.last,
            email = email,
            phone = cell,
            picture = picture.large
        )
    }
}

data class UserNameApiResponse(
    var first: String,
    var last: String
)

data class UserPictureApiResponse(
    var large: String,
    var medium: String,
    var thumbnail: String
)