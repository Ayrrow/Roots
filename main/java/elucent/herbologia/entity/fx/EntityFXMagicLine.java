package elucent.herbologia.entity.fx;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityFXMagicLine  extends EntityFX {

	Random random = new Random();
	public double colorR = 0;
	public double colorG = 0;
	public double colorB = 0;
	public int lifetime = 8;
	public ResourceLocation texture = new ResourceLocation("herbologia:entity/magicParticle");
	public EntityFXMagicLine(World worldIn, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
		super(worldIn, x,y,z,0,0,0);
		this.colorR = r;
		this.colorG = g;
		this.colorB = b;
		this.setRBGColorF(1, 1, 1);
		this.particleMaxAge = 8;
		this.particleGravity = 0.4f;
		this.xSpeed = vx + (random.nextFloat()-0.5)*0.1;
		this.ySpeed = vy + (random.nextFloat()-0.5)*0.1;
		this.zSpeed = vz + (random.nextFloat()-0.5)*0.1;
	    TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());
		this.setParticleTexture(sprite);
	}
	
	@Override
	public int getFXLayer(){
		return 0;
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		this.xSpeed *= 0.98;
		this.ySpeed *= 0.98;
		this.zSpeed *= 0.98;
		if (random.nextInt(4) >= 2 && this.particleAge > 0){
			this.particleAge --;
		}
		float lifeCoeff = ((float)this.particleMaxAge-(float)this.particleAge)/(float)this.particleMaxAge;
		this.particleRed = (float)colorR*(1.0f-lifeCoeff)+lifeCoeff;
		this.particleGreen = (float)colorG*(1.0f-lifeCoeff)+lifeCoeff;
		this.particleBlue = (float)colorB*(1.0f-lifeCoeff)+lifeCoeff;
		this.particleAlpha = lifeCoeff;
	}
}
