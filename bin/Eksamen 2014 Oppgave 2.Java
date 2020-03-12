	    public static void main(String[] args) { 
	    	int[][] salgsTabell = new int[6][5];
	    	int[] prisTabell = {200, 500, 1500, 4000};

	    	Scanner input = new Scanner(System.in);
	    	int selger = 0;
	    	int produkt = 0;
	    	int antSalg = 0;
	    	
	    	System.out.println("Selger nr.: ");
    		selger = input.nextInt();
	    	
	    	while (selger != -1) {
	    		System.out.println("Produkt nr.:");
	    		produkt = input.nextInt();
	    		System.out.println("Antall salg: ");
	    		antSalg = input.nextInt();
	    		salgsTabell[selger-1][produkt-1] =
	    		salgsTabell[selger-1][4] =
	    		salgsTabell[5][produkt-1] =
	    		salgsTabell[5][4] += antSalg;
	    		System.out.println("Selger nr.: ");
	    		selger = input.nextInt();
	    	}
	    	int sum = 0;
	    	for(int i = 0; i < salgsTabell.length-1; i++) {
	    		sum = 0;
	    		for (int j = 0; j < salgsTabell[0].length-1; j++) {
	    			sum += salgsTabell[i][j]*prisTabell[j];
	    		}
	    		System.out.printf("Selger nr: %d kr %d%n", (i+1), sum);
	    	}
	    } 