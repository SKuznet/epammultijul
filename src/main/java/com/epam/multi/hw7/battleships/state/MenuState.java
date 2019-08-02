package com.epam.multi.hw7.battleships.state;

public enum MenuState implements State<MenuState> {
    VS_HUMAN {
        @Override
        public MenuState getNextState() {
            return VS_AI;
        }

        @Override
        public MenuState getPreviousState() {
            return EXIT;
        }
    },
    VS_AI {
        @Override
        public MenuState getNextState() {
            return HELP;
        }

        @Override
        public MenuState getPreviousState() {
            return VS_HUMAN;
        }
    },
    HELP {
        @Override
        public MenuState getNextState() {
            return EXIT;
        }

        @Override
        public MenuState getPreviousState() {
            return VS_AI;
        }
    },
    EXIT {
        @Override
        public MenuState getNextState() {
            return VS_HUMAN;
        }

        @Override
        public MenuState getPreviousState() {
            return HELP;
        }
    };

    public abstract MenuState getNextState();

    public abstract MenuState getPreviousState();
}
