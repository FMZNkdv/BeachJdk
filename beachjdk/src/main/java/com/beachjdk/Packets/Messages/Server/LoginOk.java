package Packets.Messages.Server;

import Utils.Writer;
import Logic.Player;
import Logic.Device;

public class LoginOk extends Writer {

    private Player player;

    public LoginOk(Device device, Player player) {
        super(device);
        this.device = device;
        this.player = player;
        this.id = 20104;
        this.version = 1; 
    }

    @Override
    public void encode() {
        writeInt(0);
        writeInt(1);
        writeInt(0);
        writeInt(1);
        writeString("FMZNkdvSosal");
        writeString("facebookid");
        writeString("gamecenterid");
        writeInt(17);
        writeInt(24);
        writeInt(1);
        writeString("dev");
        writeString("EN");
        writeString(null);
        writeString(null);
        writeString(null);
        System.out.println("[D] Message LoginOk has been sent.");
    }
}
