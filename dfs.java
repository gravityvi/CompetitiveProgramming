  //Author:James222424
  /*** Code for dfs also includes arrangement for topological sort ***/
  
  public void dfs_util(ArrayList<Integer>[] al,boolean vis[],int x,int cnt[],int sts[],int fts[])
        {
               vis[x] = true;
                sts[cnt[0]]=x+1;
                boolean flag = false;
                for(int i=0;i<al[x].size();i++)
                {
                    if(!vis[al[x].get(i)])
                    {   flag =true;
                        cnt[0]++;
                        dfs_util(al, vis, al[x].get(i),cnt,sts,fts);
                    }    
                    
                }
            
            cnt[0]++;
            fts[cnt[0]]=x+1;
            return;
        }

        public void dfs(ArrayList[] al,int sts[],int fts[])
        {
            int count[]=new int[1];
            count[0]=0;
           boolean vis[] = new boolean[al.length];
           for(int i=0;i<al.length;i++)
           {
                if(!vis[i])
                {
                    count[0]++;
                    dfs_util(al,vis,i,count,sts,fts);
                }
           }
        }
   

        private void solve(InputReader inp, PrintWriter out1) {
               
            int n = inp.nextInt();
            int m = inp.nextInt();
            ArrayList<Integer> al[] = new ArrayList[n];

            for(int i=0;i<n;i++)
            {
                al[i] = new ArrayList<>();

            }

            for(int i=0;i<n-1;i++)
            {
                int x  = inp.nextInt();
                int y = inp.nextInt();
                al[x-1].add(y-1);
            }
            int sts[] = new int[(2*n)+5];
            int fts[] = new int[(2*n)+5];
            Arrays.fill(fts, -1);
            int ans[] = new int[n+1];
            dfs(al,sts,fts);

            

           
    }
    
    //Author:James222424
