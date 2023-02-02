package com.example.bc_parking1beta



object SampleData {

    private val Row1st= listOf(
        1,2,3,4,5,6,7,8,9,10,11,12,13
    )

    private val Row2nd= listOf(
        1,2,3,4,5,6,7,8,9,10,11,12,13
    )

    private val Row3rd= listOf(
        1,2,3,4,5,6,7,8,9,10,11,12,13
    )

    private val Row4th1= listOf(
        1,2,3
    )

    private val Row4th2= listOf(
        1,2,3,4
    )

    val collections = listOf(
        MainModel(Row1st),
        MainModel(Row2nd),
        MainModel(Row3rd),
        MainModel(Row4th1),
        MainModel(Row4th2)
    )
}