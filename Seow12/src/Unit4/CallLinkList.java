package Unit4;

public class CallLinkList {

	public CallLink firstLink;

	public int size;

	public CallLinkList() {

		firstLink = null;

	}

	public boolean isEmpty() {

		return (firstLink == null);

	}

	public void removeFirst() {

		if (!isEmpty()) {

			firstLink = firstLink.next;

			this.size--;

		}

		else {

			System.out.println("Empty Linked List");

			System.exit(0);

		}

	}

	public void insertFirst(String nf, String nl, String t, String e, String r, String p) {

		CallLink newLink = new CallLink(nf, nl, t, e, r, p);

		newLink.next = firstLink;

		firstLink = newLink;

		this.size++;

	}

	public void insertFirst(CallLink newLink) {

		newLink.next = firstLink;

		firstLink = newLink;

		this.size++;

	}

	public void insertTail(String nf, String nl, String t, String e, String r, String p) {

		CallLink newLink = new CallLink(nf, nl, t, e, r, p);

		CallLink current = firstLink;

		if (!isEmpty()) {

			while (current.next != null) {

				current = current.next;

			}

			current.next = newLink;

			this.size++;

		}

		else {

			insertFirst(nf, nl, t, e, r, p);

		}

	}

	public void insertTail(CallLink newLink) {

		CallLink current = firstLink;

		if (!isEmpty()) {

			while (current.next != null) {

				current = current.next;

			}

			current.next = newLink;

			this.size++;

		}

		else {

			insertFirst(newLink);

		}

	}

	public void insertTailPriority(String nf, String nl, String t, String e, String r, String p) {

		CallLink newLink = new CallLink(nf, nl, t, e, r, p);

		CallLink current = firstLink;

		if (!isEmpty()) {

			if (p.equals("Supervisor")) {

				while (current.next != null && current.getPriority().equals("Supervisor")) {

					if (!current.next.getPriority().equals("Supervisor")) {

						newLink.next = current.next;

						current.next = newLink;

						this.size++;

						return;

					}

					else {

						current = current.next;

					}

				}

				if (current.next == null && current.getPriority().equals("Supervisor")) {

					insertTail(nf, nl, t, e, r, p);

				}

				else {

					insertFirst(nf, nl, t, e, r, p);

				}

			}

			else if (p.equals("Important")) {

				while (current.next != null && (current.getPriority().equals("Supervisor") || current.getPriority().equals("Important"))) {

					if (current.next.getPriority().equals("Standard")) {

						newLink.next = current.next;

						current.next = newLink;

						this.size++;

						return;

					}

					else {

						current = current.next;

					}

				}

				if (current.next == null && (current.getPriority().equals("Supervisor") || current.getPriority().equals("Important"))) {

					insertTail(nf, nl, t, e, r, p);

				}

				else {

					insertFirst(nf, nl, t, e, r, p);

				}

			}

			else {

				insertTail(nf, nl, t, e, r, p);

			}

		}

		else {

			insertFirst(nf, nl, t, e, r, p);

		}

	}

	public void insertTailPriority(CallLink newLink) {

		CallLink current = firstLink;

		if (!isEmpty()) {

			if (newLink.getPriority().equals("Supervisor")) {

				while (current.next != null && current.getPriority().equals("Supervisor")) {

					if (!current.next.getPriority().equals("Supervisor")) {

						newLink.next = current.next;

						current.next = newLink;

						this.size++;

						return;

					}

					else {

						current = current.next;

					}

				}

				if (current.next == null && current.getPriority().equals("Supervisor")) {

					insertTail(newLink);

				}

				else {

					insertFirst(newLink);

				}

			}

			else if (newLink.getPriority().equals("Important")) {

				while (current.next != null && (current.getPriority().equals("Supervisor") || current.getPriority().equals("Important"))) {

					if (current.next.getPriority().equals("Standard")) {

						newLink.next = current.next;

						current.next = newLink;

						this.size++;

						return;

					}

					else {

						current = current.next;

					}

				}

				if (current.next == null && (current.getPriority().equals("Supervisor") || current.getPriority().equals("Important"))) {

					insertTail(newLink);

				}

				else {

					insertFirst(newLink);

				}

			}

			else {

				insertTail(newLink);

			}

		}

		else {

			insertFirst(newLink);

		}

	}

	public CallLink Find(int index) {

		CallLink current = firstLink;

		int counter = 0;

		if (!isEmpty()) {

			while (counter < index) {

				if (current.next == null) {

					return null;

				}

				else {

					current = current.next;

					counter++;

				}

			}

		}

		else {

			System.out.println("Empty Linked List");

		}

		return current;

	}
}
