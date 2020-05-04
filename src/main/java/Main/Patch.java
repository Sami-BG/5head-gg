package Main;

import Betting.BettingSession;

import java.util.List;

public class Patch {
	private final String id;
	private final List<String> users;
	private final BettingSession winBets = new BettingSession("winRate");
	private final BettingSession pickBets = new BettingSession("pickRate");
	private final BettingSession banBets = new BettingSession("banRate");

	/**
	 * Patch constructor.
	 * @param id The ID of the patch.
	 * @param users The list of users in the patch.
	 */
	public Patch(String id, List<String> users) {
		this.id =id;
		this.users = users;
	}
	
	public List<String> getUsers() {
		return users;
	}

	/**
	 * winBets getter.
	 * @return list of bets that bet on the win rate in this session.
	 */
	public BettingSession getWinBets() {
		return winBets;
	}

	/**
	 * pickBets getter.
	 * @return list of bets that bet on the pick rate in this session.
	 */
	public BettingSession getPickBets() {
		return pickBets;
	}

	/**
	 * banBets getter.
	 * @return list of bets that bet on the ban rate in this session.
	 */
	public BettingSession getBanBets() {
		return banBets;
	}
}
