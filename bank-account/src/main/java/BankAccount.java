class BankAccount {

    private long balance = 0;
    private boolean isOpen = false;

    public void open(){
        isOpen = true;
        balance = 0;
    }

    public long getBalance() throws BankAccountActionInvalidException{
        if(!isOpen){
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    public void deposit(long amount) throws BankAccountActionInvalidException{
        if(!isOpen){
            throw new BankAccountActionInvalidException("Account closed");
        }
        if(amount < 0){
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        this.balance += amount;
    }

    public void withdraw(long amount) throws BankAccountActionInvalidException{
        if(!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if(amount < 0){
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        if(this.balance == 0){
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        if(this.balance < amount){
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
        this.balance-=amount;
    }

    public void close(){
        isOpen = false;
    }
}