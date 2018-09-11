package timer;

public class ListenableTask {
    @Async
    public ListenableFuture<Integer> compute(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return new AsyncResult<>(sum);
    }

    static class CallBackImpl implements 
        ListenableFutureCallback<Integer> {
        @Override
        public void onFailure(Throwable ex) {
            System.out.println(ex.getMessage());
        }

        @Override
        public void onSuccess(Integer result) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        ListenableTask listenableTask = new ListenableTask();
        ListenableFuture<Integer> listenableFuture = 
            listenableTask.compute(10);
        listenableFuture.addCallback(new CallBackImpl());
    }
}