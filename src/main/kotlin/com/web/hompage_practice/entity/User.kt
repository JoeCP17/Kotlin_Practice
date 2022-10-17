package com.web.hompage_practice.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User (
    var userId:String,
    var passWord:String ,
    @Id @GeneratedValue var id:Long?=null )