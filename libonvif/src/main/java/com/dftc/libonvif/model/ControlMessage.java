package com.dftc.libonvif.model;

import android.os.Parcel;
import android.os.Parcelable;

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
public class ControlMessage implements Parcelable {
    public static final Parcelable.Creator<ControlMessage> CREATOR = new Parcelable.Creator<ControlMessage>() {
        @Override
        public ControlMessage createFromParcel(Parcel parcel) {
            return new ControlMessage(parcel);
        }

        @Override
        public ControlMessage[] newArray(int i) {
            return new ControlMessage[i];
        }
    };
    public String username;
    public String password;
    public int timeout;//5s

    public ControlMessage(String username, String password, int timeout) {
        this.username = username;
        this.password = password;
        this.timeout = timeout;
    }

    public ControlMessage() {
    }

    public ControlMessage(Parcel parcel) {
        this.username = parcel.readString();
        this.password = parcel.readString();
        this.timeout = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeInt(timeout);
    }


}
