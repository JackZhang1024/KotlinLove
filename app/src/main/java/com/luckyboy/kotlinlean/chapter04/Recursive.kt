package com.luckyboy.kotlinlean.chapter04

import android.service.media.MediaBrowserService


data class ListNode(val value:Int, var next:ListNode?)

// 尾递归操作
tailrec fun findListNode(head:ListNode?, value:Int):ListNode?{
    head?:return null
    if (head.value == value) return head
    return findListNode(head.next, value)

}

// 这个阶乘操作不是尾递归
fun factorial(n:Long):Long{
    return n* factorial(n-1)
}


data class TreeNode(val value:Int){
    var left:TreeNode? =null
    var right:TreeNode? = null
}

// 这个树的查找不是尾递归 如果是尾递归 可在fun前面加上 tailrec 进行优化 优化操作就是将这个递归变成迭代操作 尾递归容易操作stackOverFlow
fun findTreeNode(root: TreeNode?, value: Int): TreeNode?{
    root?: return null
    if (root.value == value){
        return root
    }
    return findTreeNode(root.left, value)?: findTreeNode(root.right, value)
}



/* 尾递归优化
*  函数在调用自己之后没有任何操作 就是尾递归
*
*  */
fun main(args: Array<String>) {



}

