class BankAccount {

    private long balance = 0;
    private boolean isOpen = false;

    public synchronized void open(){
        isOpen = true;
        balance = 0;
    }

    public synchronized long getBalance() throws BankAccountActionInvalidException{
        if(!isOpen){
            throw new BankAccountActionInvalidException("Account closed");
        }else{
            return balance;
        }
    }

    public synchronized void deposit(long amount) throws BankAccountActionInvalidException{
        if(!isOpen){
            throw new BankAccountActionInvalidException("Account closed");
        }else{
            if(amount < 0){
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }
            this.balance += amount;
        }
    }

    public synchronized void withdraw(long amount) throws BankAccountActionInvalidException{
        if(!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }else{
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
    }

    public synchronized void close(){
        isOpen = false;
    }
}