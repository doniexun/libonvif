package com.dftc.libonvif;

import com.dftc.libonvif.model.CameraInfomation;
import com.dftc.libonvif.model.CameraIpMessage;
import com.dftc.libonvif.model.CameraTimeMessage;
import com.dftc.libonvif.model.ControlMessage;
import com.dftc.libonvif.model.MediaMessage;

import java.util.List;

/**
 * █████ ▒ █    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 * ▒  ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 * ░      ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░  ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░      ░ ░      ░  ░
 * ░
 * Created by Administrator on 2017/10/13 0013
 */
public class OnvifUtil {
    static {
        System.loadLibrary("OnvifImplement");
    }

    public synchronized native List<CameraInfomation> scanForCameraLite(ControlMessage controlMessage);

    public synchronized native List<CameraInfomation> scanForCamera(ControlMessage controlMessage);

    public synchronized native boolean setCameraIp(CameraInfomation cameraInfomation, ControlMessage controlMessage, CameraIpMessage ip);

    public synchronized native boolean setCameraTime(CameraInfomation cameraInfomation, ControlMessage controlMessage, CameraTimeMessage time);

    public synchronized native int getCameraTime(CameraInfomation cameraInfomation, ControlMessage controlMessage, CameraTimeMessage time);

    public synchronized native boolean rebootCamera(CameraInfomation cameraInfomation, ControlMessage controlMessage);

    public synchronized native boolean setCameraMedia(CameraInfomation cameraInfomation, ControlMessage controlMessage, MediaMessage mainMediaMessage, MediaMessage subMediaMessage);

    public synchronized native boolean setLogLevel(int level);

    public synchronized native CameraInfomation getInfo(String ip, int port, ControlMessage controlMessage);
}
