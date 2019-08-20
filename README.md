# CardView and ReciclerView

## ReciclerView

Si la aplicación necesita desplegar una lista scrolleable de elementos grande (o datos que frecuentemente cambian). Se debería usar **ReciclerView**.

El **ReciclerView** es una versión más avanzada de ListView. Esté widget requiere **ViewHolder** pattern por default.

Para utilizarlo hay que implementar la librería en nuestro archivo **build.gradle**, en la sección de dependencias

```gradle
dependencies {
    implementation 'com.android.support:recyclerview-v7:28.0.0'
}
```

Es necesario implementar un **LayoutManager** al RecyclerView.

* LinearLayoutManager 
* GridLayout Manager
* Propio

### Custom adapter

```java

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names;

    private int layout;

    private OnItemClickListener onItemClickListener;

    public MyAdapter(List<String> names,int layout, OnItemClickListener onItemClickListener){
        this.names = names;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(names.get(i),onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}

```

### ViewHolder

```java
    /**
     * View holder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View view){
            super(view);
            this.name = view.findViewById(R.id.nameTextView);
        }

        public void bind(final String name,final OnItemClickListener onItemClickListener){
            this.name.setText(name);

            //Set own listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(name,getAdapterPosition());
                }
            });
        }
    }
```

### Implementación

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.names = getNames();

        this.recyclerView = findViewById(R.id.namesRecyclerView);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new MyAdapter(names,
                                     R.layout.recycler_view_item,
                     this);

        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.adapter);
    }
```

### Diferentes tipos de layout manager

* **LinearManager:** Muestra información como un stack
* **GridManager:** Muestar la información como un tabla, recibe el número de columnas
* **StaggeredManager:** Parecida a grid manager pero el contenido de la columna se ajusta al contenido

#### Ejemplo

```java
        //In line
        this.layoutManager = new LinearLayoutManager(this);

        //Grid with span count
        this.layoutManager = new GridLayoutManager(this,2);

        // Looks like grid layout but with different width items
        this.layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
```

## CardView

Es un widget que te permite mostrar la información en forma de tarjetas con una apariencia uniforme en la plataforma.

Implementar en **build.gradle**

```
implementation 'com.android.support:cardview-v7:28.0.0'
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:card_view="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".CardViewActivity">


    <android.support.v7.widget.CardView xmlns:card_view="http://schemas.android.com/apk/res-auto"
        android:id="@+id/cardView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        card_view:cardCornerRadius="4dp">

        <TextView
            android:id="@+id/textCardView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:text="Card view" />
    </android.support.v7.widget.CardView>
</LinearLayout>
```

### Efecto ripple en CardView

Debemos añadir algunso atributos a nuestro CardView

```xml
        android:clickable="true"
        android:focusable="true"
        android:foreground="?android:attr/selectableItemBackground"
```

## Picasso

Implementación en **build.gradle**

```gradle
implementation 'com.squareup.picasso:picasso:2.71828'
```

```java
//In bind method from ViewHolder
Picasso.get()
        .load(movie.getImage())//Resource Id
        .fit()
        .centerCrop()
        .into(this.imageView);//Image View
```

```xml
<ImageView
    android:id="@+id/imageCardViewRecycler"
    android:layout_width="match_parent"
    android:layout_height="200dp" />
```
