import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Redis {

    private Jedis jedis = new Jedis("localhost",6379);

    public Redis(Jedis jedis) {
        this.jedis = jedis;
    }


    public long calculTempsExecutionSet(Hebergement hebergement){

        long id = jedis.incr("Id");

        Map<String, String> hash = new HashMap<String, String>();
        hash.put("")
        long valeur1 = System.currentTimeMillis();
        jedis.hmset(id, value);
        long valeur2 = System.currentTimeMillis();
        return (valeur2 - valeur1);
    }

    public long calculTempsExecutionGet(String key){
        long valeur1 = System.currentTimeMillis();
        jedis.get(key);
        long valeur2 = System.currentTimeMillis();
        return (valeur2 - valeur1);
    }git


    public long calculTempsExecutionDelete(String key){
        long valeur1 = System.currentTimeMillis();
        jedis.del(key);
        long valeur2 = System.currentTimeMillis();
        return (valeur2 - valeur1);
    }




}
