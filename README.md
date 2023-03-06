# spring-async

透過設定 config  
並開啟 `@EnableAsync` 與 `@Async` 來使用

@Async 限制  
* 必須應用於 `public method`
* 從同一個 class 自己調用不起作用

返回類型可以是 `void` 或是 `CompletableFuture<T>` 或是 `Future<T>`

如果返回類型是 `void`，發生 exception 不會傳播到調用的 thread，因此需要額外配置來處理異常  

透過實現 `AsyncUncaughtExceptionHandler`來自訂義異步異常處理，當未捕獲異步異常時則調用它

