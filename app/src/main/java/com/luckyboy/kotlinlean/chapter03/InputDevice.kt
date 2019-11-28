package com.luckyboy.kotlinlean.chapter03

interface InputDevice{

    fun input(event:Any)

}

interface USBInputInputDevice:InputDevice  // USBInputInputDevice 继承InputDevice

interface BLEInputDevice:InputDevice // 蓝牙设备

class USBMouse(var name:String):USBInputInputDevice, OpticalMouse{

    override fun input(event: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return "鼠标名称是 $name"
    }

}

// 话筒
abstract class Speaker(var name:String):USBInputInputDevice{

    override fun input(event: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return "话筒名称是 $name"
    }

}

class LogitecSpeaker:Speaker("罗技话筒"){


}

interface OpticalMouse{

}


class Computer{

    fun addUSBInputDevice(inputDevice: InputDevice){
        println("add usbinput device: $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: InputDevice){
        println("add bleinput device: $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice){
        when(inputDevice){
            is BLEInputDevice->{
                addBLEInputDevice(inputDevice)
            }
            is USBInputInputDevice->{
                addUSBInputDevice(inputDevice)
            }
            else->{
                throw IllegalArgumentException("输入设备类型不支持")
            }
        }
    }




}


fun main(args: Array<String>) {
    val compute = Computer()
    val mouse  = USBMouse("罗技")
    compute.addInputDevice(mouse)
    val speaker= LogitecSpeaker()
    compute.addInputDevice(speaker)


}


