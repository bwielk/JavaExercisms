class PascalsTriangleGenerator{

    public int[][] generateTriangle(int limit){
        int[][] arrayResult = new int[limit][];
        for(int i=0; i<limit; i++){
            int[] row = new int[i+1];
            row[0]=1;
            row[row.length-1]=1;
            if(i>1){
                int[] previousRow = arrayResult[i-1];
                for(int j=1; j<row.length-1; j++){
                    try{
                        row[j] = previousRow[j-1]+ previousRow[j];
                    }catch (ArrayIndexOutOfBoundsException e){
                        e.printStackTrace();
                    }

                }
            }
            arrayResult[i]=row;
        }
        for(int[] arr : arrayResult){
            System.out.println(String.format("Size of an array : %s", arr.length));
        }
        return arrayResult;
    }
}
