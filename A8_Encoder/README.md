# A8_Encoder - 編碼工具

**此文件由AI撰寫，個人強烈建議用Eclipse IDE建置**

## 📋 專案說明

A8_Encoder 是一個簡單易用的JavaFX應用程式，能將文字轉換成ASCII碼值序列。非常適合學習字元編碼與文件操作的基礎概念。

## ✨ 功能特性

- **編碼**：將輸入的文字轉換為ASCII碼值序列
- **新建**：建立新的編碼輸出檔案
- **存檔**：將編碼結果儲存至檔案（`encoded_text.txt`）
- **複製**：一鍵複製編碼結果至系統剪貼簿
- **清空**：清除所有輸入和輸出內容

## 🛠️ 技術棧

- **語言**：Java 17
- **GUI框架**：JavaFX 17.0.1
- **構建工具**：Maven 3.6+
- **測試框架**：JUnit 5.8.1

## 📦 系統需求

- Java Development Kit (JDK) 17 或更新版本
- Maven 3.6 或以上

## 🚀 快速開始

**(這是AI寫的，個人建議使用Eclipse IDE)**

### 1. 複製專案

```bash
cd A8_Encoder
```

### 2. 構建專案

```bash
mvn clean compile
```

### 3. 執行應用

```bash
mvn clean javafx:run
```

或直接使用：

```bash
mvn compile exec:java -Dexec.mainClass="encoder.coder_main"
```

## 📁 專案結構

```
A8_Encoder/
├── src/
│   ├── main/
│   │   ├── java/encoder/
│   │   │   ├── coder_main.java      # 主應用程式 & UI 界面
│   │   │   └── Deal.java            # 核心業務邏輯處理
│   │   └── resources/               # 資源檔案
│   └── test/
│       └── java/                    # 單元測試
├── pom.xml                          # Maven 配置檔案
├── .classpath                       # Eclipse 類路徑設定
└── .project                         # Eclipse 專案設定
```

## 💡 使用說明

1. **輸入文字**：在「輸入」欄位中輸入要編碼的文字
2. **按下編碼按鈕**：文字將轉換為ASCII碼值序列（以數字串聯表示）
3. **儲存或複製**：
   - 按「存檔」將結果儲存至 `encoded_text.txt`
   - 按「複製」將結果複製至剪貼簿
4. **清空**：按「清空」按鈕重新開始

## 📝 編碼範例

| 輸入      | 輸出               |
| ------- | ---------------- |
| `A`     | `65`             |
| `AB`    | `6566`           |
| `Hello` | `72101108108111` |

## 📋 核心類別說明

### coder_main.java

- 主應用程式入口，繼承自 `Application`
- 負責 JavaFX UI 元件的建立與佈局
- 管理按鈕事件與使用者互動

### Deal.java

- 處理所有的業務邏輯：編碼、檔案操作、剪貼簿處理
- 包含 5 個主要操作：新建、存檔、編碼、複製、清空

## 🔧 依賴項

- **javafx-controls**: JavaFX UI 控制項
- **javafx-fxml**: FXML 標記語言支持
- **junit-jupiter-api/engine**: JUnit 5 測試框架

## 📄 檔案輸出

執行「存檔」功能後，將在專案根目錄生成 `encoded_text.txt` 檔案，內容為編碼後的ASCII碼值序列。

## 🤝 貢獻

此專案為教學用途，歡迎提交改進建議或修正。
