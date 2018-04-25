package Model;

public class Sort {
  // an array sort by description //
    public static void sortByDescription(Transaction[] x) {
      int N = x.length;
      for (int i = 0; i < N; i++) {
        for (int j = i; j > 0 && lesstrans(x[j], x[j - 1]); j--) {
          exch(x, j, j - 1);
        }

      }
    }
    // an array sort by user//
    public static void sortByUser(Transaction[] x) {
      int N = x.length;
      for (int i = 0; i < N; i++) {
        for (int j = i; j > 0 && lessuser(x[j], x[j - 1]); j--) {
          exch(x, j, j - 1);
        }

      }

    }

    // an array sort by the date//
    public static void sortByDate(Transaction[] x) {
      int N = x.length;
      for (int i = 0; i < N; i++) {
        for (int j = i; j > 0 && lessdate(x[j], x[j - 1]); j--) {
          exch(x, j, j - 1);
        }

      }

    }

static void exchange(Transaction t[], int i, int j) {
    	Transaction tmp = t[i];
    	t[i] = t[j];
    	t[j] = tmp;
        }

public static void sortByAmount(Transaction t[]) {
    	int i,j;
    	int mi; 
    	Transaction mv;

    	for (i=0; i<t.length-1; i++) {
    		mv = t[i]; mi = i;
    	    for (j=i+1; j < t.length; j++) {
    		if (lesstest(t[j],mv)) { 
    		    mi = j ; mv = t[j]; 
    		}
    	    }
    	    exchange(t,i,mi);
    	}
        }
private static boolean lesstest(Transaction a, Transaction a2) {
    if (a == null)
      return false;
    return a.compareByAmount(a2) < 0;
  }

    private static boolean lesstrans(Transaction a, Transaction a2) {
      if (a == null)
        return false;
      return (a.compareDescription(a2) < 0);

    }

    private static boolean lessuser(Transaction a, Transaction a2) {
      if (a == null)
        return false;
      return (a.compareByUser(a2) < 0);
    }

    private static boolean lessdate(Transaction a, Transaction a2) {
      if (a == null)
        return false;
      return (a.compareByDate(a2) < 0);
    }


    private static void exch(Transaction[] a, int i, int j) {
      Transaction swap = a[i];
      a[i] = a[j];
      a[j] = swap;
    }
}