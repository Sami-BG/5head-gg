package DatabaseHandler;

import Betting.SigmoidAdjustedGain;
import Database.DatabaseHandler;
import Main.Champion;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Main.User;
import Betting.Bet;

import java.util.ArrayList;
import java.util.List;

public class QueryTest {
DatabaseHandler db;
    @Before
    public void setUp() throws Exception {
        db = new DatabaseHandler();
    }
    @Test
    public void testUserQueries() {
        User usr1 = new User("usrID", "usrName", 320, "brown.edu", "pswrd");
        User usr2 = new User("usrID_1", "usrName_1", 9000, "gmail.com", "pswrd_1");

        try {
            db.addNewUser("usrID", "usrName", "320", "brown.edu", "pswrd");
            db.addNewUser("usrID_1", "usrName_1", "9000", "gmail.com", "pswrd_1");
            assertTrue(db.getUser("usrID").equals(usr1));
            assertEquals(db.getUser("usrID_1", "pswrd_1"), usr2);
            db.updateReputation("usrID", "1000");
            assertEquals(db.getUser("usrID").getReputation(), "1000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testChampionQueries() {
        List<String> winRate = new ArrayList<>();
        List<String> banRate = new ArrayList<>();
        List<String> pickRate = new ArrayList<>();
        winRate.add("Aatrox");
        winRate.add("0.55");
        banRate.add("Aatrox");
        banRate.add("0.75");
        pickRate.add("Aatrox");
        pickRate.add("0.45");
        Champion aatrox = new Champion("Aatrox", winRate, banRate, pickRate);
        try {
            db.addRatestoChamps("Aatrox", "10.10", "0.55", "0.75", "0.45");
            assertEquals(db.getChampion("Aatrox"), aatrox);
            assertTrue(db.getChampionWinRateFromPatch("10.10", "Aatrox") == 0.55);
            assertTrue(db.getChampionBanRateFromPatch("10.10", "Aatrox") == 0.75);
            assertTrue(db.getChampionPickRateFromPatch("10.10", "Aatrox") == 0.45);
            db.createNewPatch("10.11");
            db.addRatestoChamps("Aatrox", "10.11", "0.35", "0.25", "0.45");
            assertTrue(db.getChampionWinRateFromPatch("10.11", "Aatrox") == 0.35);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBetQueries() {
        SigmoidAdjustedGain gainFunc = new SigmoidAdjustedGain(1.5, 0.75, 0.0, 0.0);
        Bet bet1 = new Bet("1", "usr_ID", 50, 0.5, "Aatrox", gainFunc, "Pick", "10.10");
        Bet bet2 = new Bet("2", "usr_ID_1", 50, 0.5, "Aatrox", gainFunc, "Ban", "10.10");
        Bet bet3 = new Bet("3", "usr_ID_1", 50, 0.5, "Aatrox", gainFunc, "Win", "10.11");
        Bet bet4 = new Bet("4", "usr_ID_1", 50, 0.5, "Mumu", gainFunc, "Pick", "10.10");

        List<Bet> bets = new ArrayList<>();
        bets.add(bet2);
        bets.add(bet4);
        try {
            db.createNewBet("1", "usr_ID", "Aatrox", "Pick", "0.5", "50", "10.10");
            db.createNewBet("2", "usr_ID_1", "Aatrox", "Ban", "0.5", "50", "10.10");
            db.createNewBet("3", "usr_ID_1", "Aatrox", "Win", "0.5", "50", "10.11");
            db.createNewBet("4", "usr_ID_1", "Mumu", "Pick", "0.5", "50", "10.10");

            assertEquals(db.getBet("1"), bet1);
            assertEquals(db.getUserBetsOnPatch("10.10", "usr_ID_1"), bets);
            assertTrue(db.countNumberOfBets("Aatrox", "10.10") == 2);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
