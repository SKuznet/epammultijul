package com.epam.multi.hw7.battleships.state;


public enum GameState implements State<GameState> {
    PLAYER1_IS_PLACING_SHIPS {
        @Override
        public GameState getNextState() {
            return PLAYER2_IS_PLACING_SHIPS;
        }
    },
    PLAYER2_IS_PLACING_SHIPS {
        @Override
        public GameState getNextState() {
            return PLAYER2_IS_ATTACKING;
        }
    },
    PLAYER1_IS_ATTACKING {
        @Override
        public GameState getNextState() {
            return PLAYER2_IS_ATTACKING;
        }
    },
    PLAYER2_IS_ATTACKING {
        @Override
        public GameState getNextState() {
            return PLAYER1_IS_ATTACKING;
        }
    };

    public abstract GameState getNextState();

}
