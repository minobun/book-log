# 感想
コンポーネントベースって2018年3月現在の本だけど今どうなんだろ。
レイアウトパターンってAtomsに入るんやな

```https://zenn.dev/mutex_inc/articles/beca85dd7fdcae#2.2.2.-%E6%97%A2%E5%AD%98%E3%81%AE%E3%83%87%E3%82%B6%E3%82%A4%E3%83%B3%E3%83%91%E3%82%BF%E3%83%BC%E3%83%B3%E3%81%AE%E5%95%8F%E9%A1%8C%E7%82%B9
一貫性と拡張性を開発にもたらすAtomic Designですが、チーム開発において少々扱いにくいと個人的に思う点が2つあります。まず、コンポーネントの粒度を決定する基準が曖昧になることです。例えば、所望のコンポーネントをOrganismsに作ったらいいのか、Moleculesに作ったらいいのか迷う場面が多々あります。確かに基準自体はあるのですが、アプリケーションの規模に関わらずコンポーネントを5つの粒度に分けるので、アプリケーションごとに基準が変わってきます。このようにAtomic Designでは明確な基準を設定する必要があるのです。

また、（私の）メンタルモデルとの不一致という難点があります。例えば、フロントエンド開発においてある機能を追加したいと考えたとき、まずUIを確認し、変更が必要な場所を特定する場合が多いです。このような際にどのコンポーネントが変更箇所に関係してくるかどうかを直感的に把握したいのですが、Atomic DesignではUIの構造とディレクトリの構造が対応していないので、開発者用ツールや拡張機能に頼る必要があります。些細なことですが、開発体験を考えるとより直感的なディレクトリ構造にしておきたいものです。
```


Atomic Designは階層が多く使われない層が出てくるみたい。
また、StoryBookの形骸化などメンテナンス性が低そう。
https://techblog.zozo.com/entry/storybook-msw-chromatic

# メモ
- ユーザーが使いやすいサービスをより少ない工数で作る→コンポーネントベースで確実で効率が良い開発を実現する。
- 「機能をコンポーネントに分ける」という考え方は、確実で効率が良い開発を実現できる。
  - 複雑なUIも確実に組み立てることができる。
  - しっかりとコンポーネントごとに分けられたUIの機能は再利用性が高い
  - 多くの画面に対して少ないコードで実装できる。
  - 再利用性が高いコンポーネントは、統一された使い勝手をユーザーに提供できる。
  - 画面別ではなく、機能別に分けられたUI設計が複数人の平衡実装を実現し、開発速度がアップ。
- 自分の直感でUIの操作方法がわかる。

## 直感的なUIの7つの定義
1. UIの見た目から与えられる情報が適切なこと
2. UIが期待通りに動作すること
3. UIが効率的で最小の工数で目的を達成できること
4. UIが適切なタイミングでフィードバックを返すこと
5. ユーザーがミスを犯してもすぐに修正可能なこと
6. ユーザーが安心してアプリケーションを遷移できること
7. それ以外でストレスがないこと

## CSSの努力
CSSの設計
1. より後に読み込まれたスタイルが優先される
2. スタイルは継承される
3. 詳細に指定したスタイルが優先される

CSSは簡単にあとから上書きできてしまうため、変更させたくない箇所が変更してしまうリスクがある。

CSSの詳細度
高い
- インラインスタイル
- IDセレクタ
- 疑似クラス
- 属性セレクタ
- クラスセレクタ
- タイプセレクタ
- 全称セレクタ
低い

CSSは過去に書いたスタイルを意識せざるを得ない構成になってしまっている。
そのために、OOCSS（オブジェクト指向CSS）やBEM（Block, Element, Modifier）などの考え方が出てきた。

OOCSS：クラスセレクターを相互に作用させるようにUIを作る
BEM：Block, Element, Modifierという3パターンのクラスセレクターを組み合わせて作る

しかしこれらの方法でもCSSは破綻しやすかった。
本当のコンポーネント化はできなかった。

## スタイルガイドの普及
スタイルガイドはUIが再利用できる形で一覧化されている。
スタイルガイドジェネレーターは、プロダクトのために書いたCSSのコードにスタイルガイド用の情報をフォーマットに従ってコメントとして追加したものをパースして自動的にスタイルガイドとして参照するUIコンポーネントを一覧にしたHTMLを出力してくれる。
→スタイルガイドを最新の状態に保ちやすくなる。

ただし、スタイルガイドがプロダクトから乖離する問題がある。
→UIの開発フロート開発環境を工夫することで解決可能

## UI開発ワークフロー
デザインカンプ・ファーストなワークフローになっている。
デザインカンプ：デザインの完成品
静的なデザインカンプと同じデザインの実現は難しい。

## UIフレームワークの普及
UIフレームワークはデザイナーがいないときの救世主

## SPAの普及
SPA：基本的にすべての画面遷移をJavaScriptで制御する設計手法

## コンポーネントベースの開発
複雑なUIを確実かつ堅牢に組み上げられる手段である。

## 堅牢なUI開発の実現
メリット
- コンポーネント単位でテストできる
- 不具合のリスク・ポイントを減らすことができる
- メンテナンスがしやすくなる
- 解決する問題が小さくなる

## 開発作業を効率化する
- 再利用で実装量を減らす
- 平衡開発で待ち時間を減らす
- 仕様変更による手戻り作業を最小化する
- 新規参入開発メンバーを最短で戦力化する
- 複数のテスト・アプローチでテスト工数を下げる
- 複数アプリケーションの開発を容易にする

## コンポーネント・ベースUI開発がもたらすユーザー・メリット
UI＝会話　UIコンポーネント＝単語

## コンポーネント設計の基本
1. カプセル化
2. 置換可能
3. 再利用可能
4. コンポーネントを別のコンポーネントを組み合わせて作成可能
   
コンポーネント設計で押さえておきたい2つのポイント
__単一責任の原則__
__関心の分離__

## コンポーネント・ベースUI開発の現状
HTML・CSS・JavaScript：コンポーネント化に向かない特性を持つ

## React
コンポーネント化がかんたんにできる
コンポーネント化の手段が統一される
宣言的にコードが記述されるため、コンポーネントを理解しやすい
現時点では広く使われているライブラリである


# Atomic DesignによるUIコンポーネント設計
Atoms→Molecules→Organisms→Templates→Pages
化学用語→開発者用の共通言語
通常の開発用語→開発者以外に対しても使う用語

小さなコンポーネントは大きなコンポーネントを含まない。

## デザイン視点で関心の分離を考える
|Order|行動プロセス|デザインすべき対象|
|--|--|--|
|1|画面全体から情報を探す|画面全体のレイアウト|
|2|興味を引くコンテンツを見つける|ユーザーの行動を促すコンテンツの見せ方|
|3|コンテンツに促されて行動をする|行動を阻害しない操作性|
|4|全体を通してサービスに良い印象を抱く（そして再訪する）|デザインの統一性


|Order|層|関心|
|--|--|--|
|1|Templates|画面全体のレイアウト|
|2|Organisms|ユーザーの行動を促すコンテンツの見せ方|
|3|Molecules|行動を阻害しない操作性|
|4|Atoms|デザインの統一性

階層化メリット
- 全体を考慮する必要がなく、1つの層の責務にかかわる課題だけに集中できる
- 同一層に属するコンポーネントであれば差し替えることができる
- 上位層のUIコンポーネントの変更が下位の層に影響することがない。


## Atomsの設計
Atomsとなるべきなカテゴリー
- プラットフォームのデフォルトUI
  - ボタン
  - テキスト
  - テキスト・インプット
- プラットフォームのデファクト・スタンダードなUI
  - バルーン
  - バッジ
  - カード
- レイアウト・パターン
  - グリッド
  - 聖杯レイアウト
  - メディア・オブジェクト
- セマンティックなデザイン要素
  - 見出し
  - 本文
  - コンテンツ画像
    - 画像表示の遅延とか
  - アイコン
  - デコレーション枠や区切り線
  - アニメーション
デザインの統一感は重要

## Moleculesの構成
ユーザーの動機に対する機能を提供する
ユーザーが意識してやりたいと思っていることに対して機能を提供する。
- 検索フォーム
  - ボタン＋テキスト・インプット＋テキストの3つのコンポーネントから成立
- メッセージフォーム

重要なポイント
1. 以前に使ったことがある。または、直感的に使い方がわかる形をしている。
2. 似た形をしたものは常に同じ挙動をする。

## Organismsの構成
独立して成立するコンテンツを提供する

Molecules→独立して存在できるコンポーネントではなく、ほかのコンポーネントの機能を助けるヘルパーとしての存在意義が強いコンポーネント
Organisms→独立して存在できるスタンドアローンなコンポーネント

## Template, Pages
Template：ページ・レイアウトに対する責務を担う
Pages：Templates層のコンポーネントに実際のコンテンツを流し込んだものである。










