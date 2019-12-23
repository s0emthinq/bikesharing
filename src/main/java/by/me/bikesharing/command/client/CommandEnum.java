package by.me.bikesharing.command.client;


import by.me.bikesharing.command.*;

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SHOW_ALL_BIKES {
        {
            this.command = new ShowAllBikesCommand();
        }
    },
    FORWARD_TO_UPDATE_BIKE {
        {
            this.command = new ForwardToUpdateBikeFormCommand();
        }
    },
    UPDATE_BIKE {
        {
            this.command = new UpdateBikeCommand();
        }
    },
    FORWARD_TO_ADD_BIKE {
        {
            this.command = new ForwardToAddBikeFormCommand();
        }
    },
    ADD_BIKE {
        {
            this.command = new AddBikeCommand();
        }
    },
    ORDER_BIKE {
        {
            this.command = new OrderBikeCommand();
        }
    },
    FORWARD_TO_ORDER_BIKE {
        {
            this.command = new ForwardToOrderBikeCommand();
        }
    },
    DELETE_BIKE {
        {
            this.command = new DeleteBikeCommand();
        }
    },
    SHOW_ALL_USER_ORDERS {
        {
            this.command = new ShowAllUsersOrders();
        }
    },
    CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguageCommand();
        }

    }, FINISH_ORDER {
        {
            this.command = new FinishOrderCommand();
        }
    }, FORWARD_TO_MAKE_DEPOSIT {
        {
            this.command = new ForwardToMakeDepositCommand();
        }
    }, MAKE_DEPOSIT {
        {
            this.command = new MakeDepositCommand();
        }
    }, REGISTER {
        {
            this.command = new RegisterCommand();
        }
    }, FORWARD_TO_LOGIN {
        {
            this.command = new ForwardToLogin();
        }
    }, FORWARD_TO_REGISTER {
        {
            this.command = new ForwardToRegisterCommand();
        }
    }, SHOW_ALL_USERS {
        {
            this.command = new ShowAllUsersCommand();
        }
    }, BLOCK_USER {
        {
            this.command = new BlockUserCommand();
        }
    }, UNBLOCK_USER {
        {
            this.command = new UnblockUserCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}