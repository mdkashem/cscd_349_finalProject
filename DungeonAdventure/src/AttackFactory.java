

import java.util.HashMap;
import java.util.Map;

public class AttackFactory {
	private Map<String, Attack> attacks = new HashMap<String, Attack>();
	
	public Attack getAttack(String name ){
		Attack attack = attacks.get(name);
		if(attack==null){
			attack = new FireballAttack(name);
			attacks.put(name, attack);
			
		}
		return attack;
		
	}

}
