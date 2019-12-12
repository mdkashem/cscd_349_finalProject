package dungeon;


import java.util.HashMap;
import java.util.Map;

public class AttackFactory {
	private Map<String, Attack> attacks = new HashMap<String, Attack>();
	
	public Attack getFireBallAttack(String name ){
		Attack attack = attacks.get(name);
		if(attack==null){
			attack = new FireballAttack(name);
			attacks.put(name, attack);
			
		}
		return attack;
		
	}
	
	public Attack getCrushingBlow(String name ){
		Attack attack = attacks.get(name);
		if(attack==null){
			attack = new CrushingBlow(name);
			attacks.put(name, attack);
			
		}
		return attack;
		
	}
	public Attack getBaseAttack(String name ){
		Attack attack = attacks.get(name);
		if(attack==null){
			attack = new BaseAttack(name);
			attacks.put(name, attack);
			
		}
		return attack;
		
	}

}
