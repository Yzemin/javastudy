package com.ziv.fog.structure.composite.dome1;

public interface Component {
	void operation();
}
interface Leaf extends Component {
	
}
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}