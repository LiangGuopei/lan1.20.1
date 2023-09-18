package cn.catver.lanmod.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class ExampleMixin {
	@Inject(at = @At("TAIL"), method = "onPlayerConnect")
	private void onConnection(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
		player.sendMessage(Text.literal("\u00a7c[\u7528\u6237\u987b\u77e5\u4e0e\u514d\u8d23\u58f0\u660e] \u00a7f\u672c\u5de5\u5177\u662f\u7531\u5185\u8499\u53e4\u7814\u79d1\u79d1\u6280\u6709\u9650\u516c\u53f8\u5f00\u53d1\u8fd0\u8425\uff0c\u4e0e\u4efb\u4f55\u6e38\u620f\u516c\u53f8\u3001\u673a\u6784\u6216\u7ec4\u7ec7\u65e0\u5173\u3002\u6211\u4eec\u6ca1\u6709\u4ee3\u7406\u6743\u3001\u5546\u6807\u6743\u6216\u5e7f\u544a\u6743\u7b49\u4e0e\u4efb\u4f55\u6e38\u620f\u516c\u53f8\u76f8\u5173\u7684\u6743\u5229\u3002\u6211\u4eec\u4e0d\u65ad\u52aa\u529b\u786e\u4fdd\u6211\u4eec\u7684\u5de5\u5177\u7b26\u5408\u76f8\u5173\u6cd5\u5f8b\u6cd5\u89c4\u548c\u9053\u5fb7\u89c4\u8303\uff0c\u4f46\u662f\u6211\u4eec\u4e0d\u80fd\u4fdd\u8bc1\u5b83\u4eec\u5728\u6240\u6709\u60c5\u51b5\u4e0b\u90fd\u7b26\u5408\u8fd9\u4e9b\u89c4\u5b9a\u3002\u56e0\u6b64\uff0c\u4f7f\u7528\u672c\u5de5\u5177\u6240\u4ea7\u751f\u7684\u4efb\u4f55\u540e\u679c\uff0c\u672c\u516c\u53f8\u6982\u4e0d\u8d1f\u8d23\u3002\u5982\u679c\u60a8\u6709\u4efb\u4f55\u95ee\u9898\u6216\u7591\u8651\uff0c\u8bf7\u8054\u7cfb\u6211\u4eec\u4ee5\u83b7\u5f97\u66f4\u591a\u4fe1\u606f\u3002"));
		new Thread(() -> {
			try {
				Thread.sleep(1000);
				player.getServer().openToLan(GameMode.DEFAULT,true,27805);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
}