import java.util.*;
import java.awt.Color;
public class test{
	
	static ParticleForceRegistry registry = new ParticleForceRegistry();
	static LinkedList<Particle> listOfParticles = new LinkedList<Particle>();
	static LinkedList<Particle> structure = new LinkedList<Particle>();
	static ParticleGravity poids = new ParticleGravity(new Apoint(0,1,0));
	static ParticleGravity lancement = new ParticleGravity(Apoint.multByScalar(Apoint.normalize(new Apoint(1000,-0.8*800+310,0)),2));

		

	public static void simulate(double dt,int niter){

		if(listOfParticles.size()==2){
		{int u = 0;

							while(u<20)
							{		listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*1-u*30,0),0.01,new Apoint(0,0,0),Color.white,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*3-30*(u),0),0.01,new Apoint(0,0,0),Color.orange,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*5-30*(u),0),0.01,new Apoint(0,0,0),Color.red,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*7-30*(u),0),0.01,new Apoint(0,0,0),Color.green,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*9-30*(u),0),0.01,new Apoint(0,0,0),Color.yellow,30));
									
									u = u+10;	
							}}			
							Particle t = listOfParticles.get(0);
				t.position = new Apoint(132-42,609-55,0);t.velocity=Apoint.multByScalar(Apoint.normalize(new Apoint(1,0.1,0)),3);
				registry.clear();
				registry.add(listOfParticles.get(0),new ParticleGravity(Apoint.multByScalar(Apoint.normalize(new Apoint(1000,-listOfParticles.size()*30*Math.random(),0)),5)));
		}


		int m =listOfParticles.size();
		int n = 0;
		while(n<m){
			if(Apoint.magnitude(listOfParticles.get(n).velocity)!=0 && listOfParticles.get(n).position.y ==0.8*800-30&& !structure.contains(listOfParticles.get(n)))
				{listOfParticles.remove(listOfParticles.get(n));
								m=m-1;}
			n++;
		}



		
			for(int j = 1;j<listOfParticles.size();j++)
			{if(listOfParticles.get(0).position.x+listOfParticles.get(0).rayon>=listOfParticles.get(j).position.x-listOfParticles.get(j).rayon && listOfParticles.get(0).position.y+listOfParticles.get(0).rayon>=listOfParticles.get(j).position.y-listOfParticles.get(j).rayon && listOfParticles.get(0).position.y-listOfParticles.get(0).rayon<=listOfParticles.get(j).position.y+listOfParticles.get(j).rayon && listOfParticles.get(0).position.x-listOfParticles.get(0).rayon<=listOfParticles.get(j).position.x+listOfParticles.get(j).rayon){
							double  a=listOfParticles.get(0).position.x+listOfParticles.get(0).rayon;
							listOfParticles.get(0).position.x=listOfParticles.get(j).position.x-listOfParticles.get(j).rayon-listOfParticles.get(0).rayon;
							listOfParticles.get(j).position.x=a+listOfParticles.get(j).rayon;
							
			
							listOfParticles.get(0).velocity.x = -listOfParticles.get(0).velocity.x;
							listOfParticles.get(j).velocity.x = -0.3*listOfParticles.get(0).velocity.x;
			
						}}

			for(int i =1;i<listOfParticles.size();i++){
				if(listOfParticles.get(i).velocity.x !=0 && (listOfParticles.get(i).position.x+listOfParticles.get(i).rayon<=1000-30 || listOfParticles.get(i).position.x-listOfParticles.get(i).rayon>=1000+30)&&listOfParticles.get(i).position.y!=(0.8*800-30)){
					registry.add(listOfParticles.get(i),poids);
					listOfParticles.get(i).rebound = 0;

					
				}

				
			}	//clear




		


		for(Particle b : listOfParticles){
			if( !(b.position.x-b.rayon>1000+30 || b.position.x+b.rayon<1000-30)){
				if(!structure.contains(b))
				structure.add(b);
			}
			else{
				if(structure.contains(b))
				for(int i =structure.indexOf(b);i<structure.size()-1;i++){
					Apoint newPos = new Apoint(Apoint.add(structure.get(i+1).position,new Apoint(0,60,0)));
					structure.get(i+1).position = new Apoint(newPos);
				}
				structure.remove(b);
			}
		}
		

		registry.updateForces(dt);
		for(Particle b : listOfParticles)
			b.integrate(dt);
		{Particle t = listOfParticles.get(0);
				if(t.position.x+t.rayon>=1400)
					{t.position = new Apoint(132-42,609-55,0);t.velocity=Apoint.multByScalar(Apoint.normalize(new Apoint(1,0.1,0)),3);registry.clear();registry.add(listOfParticles.get(0),new ParticleGravity(Apoint.multByScalar(Apoint.normalize(new Apoint(1000,-listOfParticles.size()*30*Math.random(),0)),5)));
}}
	}

	public static void main(String [] args){
		listOfParticles.add(new Particle(new Apoint(132-42,609-55,0),0.01,Apoint.multByScalar(Apoint.normalize(new Apoint(1,0.1,0)),3),Color.black,3));
		registry.add(listOfParticles.get(0),new ParticleGravity(Apoint.multByScalar(Apoint.normalize(new Apoint(1000,-listOfParticles.size()*30*Math.random(),0)),5)));

		{int u = 0;
							while(u<20)
							{		listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*1-u*30,0),0.01,new Apoint(0,0,0),Color.white,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*3-30*(u),0),0.01,new Apoint(0,0,0),Color.orange,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*5-30*(u),0),0.01,new Apoint(0,0,0),Color.red,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*7-30*(u),0),0.01,new Apoint(0,0,0),Color.green,30));
									listOfParticles.add(new Particle(new Apoint(1000,800*0.80-30*9-30*(u),0),0.01,new Apoint(0,0,0),Color.yellow,30));
									
									u = u+10;	
							}}			


		FenetrePlotCourbe fenetre = new FenetrePlotCourbe(listOfParticles);
		fenetre.lancement();
	}
}