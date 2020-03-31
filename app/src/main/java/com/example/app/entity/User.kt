package com.example.app.entity

//在主构造参数前面加上 var/val 使构造参数同时成为成员变量
data class User constructor(var username: String?, var password: String?, var code: String?) {

    constructor() : this(null, null, null)




}
