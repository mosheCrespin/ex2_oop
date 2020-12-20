package Tests;

import gameClient.Ex2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class testForGameClient {
    @Test
    void checkNumberOfAgents(){
        Ex2 test=new Ex2();
        test.run(0);
        Assertions.assertEquals(1,test.getArena().getNumberOfAgents());
        test.run(11);
        Assertions.assertEquals(3,test.getArena().getNumberOfAgents());
    }
    @Test
    void checkIfTheAgentsGoesToTheBestPokemon(){
        Ex2 test=new Ex2();
        test.run(2);
        Assertions.assertEquals(3,test.getArena().getAgents().get(0).getSrcNode());//in this place there is the best pokemon
    }
    @Test
    void checkEdge(){
        Ex2 test=new Ex2();
        test.run(2);
        Assertions.assertEquals(9,test.getArena().getPokemons().get(0).get_edge().getSrc());//check if the edge is the real one
    }
}
