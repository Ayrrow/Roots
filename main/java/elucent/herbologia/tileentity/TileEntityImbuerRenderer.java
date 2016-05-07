package elucent.herbologia.tileentity;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityImbuerRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,
			float partialTicks, int destroyStage) {
		if (te instanceof TileEntityImbuer){
			TileEntityImbuer tei = (TileEntityImbuer)te;
			if (tei.stick != null){
				GL11.glPushMatrix();
				EntityItem item = new EntityItem(Minecraft.getMinecraft().theWorld,x,y,z,tei.stick);
				item.hoverStart = 0;
				Random random = new Random();
				random.setSeed(item.getEntityItem().hashCode());
				GL11.glTranslated(x+0.5, y+0.5, z+0.5);
				GL11.glRotated(tei.spin,0,1.0,0);
				GL11.glTranslated(0.25, 0, 0);
				GL11.glRotated(45, 0, 0, 1.0);
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(item, 0, 0, 0, 0, 0, true);
				GL11.glPopMatrix();
			}
			if (tei.dust != null){
				
			}
		}
	}
	
}
